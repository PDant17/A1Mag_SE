library(car)
library(graphics)
library (sm)
library(BSDA)
library(tseries)
library(lmtest)
library(MASS)
library(nortest)
library(e1071)
library(SiZer)
library(exactRankTests)
library(lmPerm)
library(effsize)


################################################################################
################################################################################
######## data analysis: controlled experiment


## caricare il dataset

#### final questionnaire
final <- read.table("/Users/carmine/Library/CloudStorage/OneDrive-UniversitàdiSalerno/CORSI/MQS - Software Metrics, Analytics, and Quality/LEZIONI/L7 data experiment final questionnaire.csv", header = TRUE, sep = ";", dec = ".")

#### datui
dati <- read.table("/Users/carmine/Library/CloudStorage/OneDrive-UniversitàdiSalerno/CORSI/MQS - Software Metrics, Analytics, and Quality/LEZIONI/L7 data experiment.csv", header = TRUE, sep = ";", dec = ".")

#### BARPLOT
tab=table(dati$ABILITY)
barplot(tab,horiz=TRUE,xlab="ABILITY")

tab=table(dati$METHOD, dati$ABILITY) 
barplot(tab, legend=rownames(tab), col=c("red","yellow","green"), ylab="observation")

##### selection of distributions
CD <- dati[which(dati["METHOD"] == "CD"),]
ER <- dati[which(dati["METHOD"] == "ER"),]

#### descriptive statistics
summary(CD$CS)
summary(ER$CS)


### standard deviation
sd(CD$CS)
sd(ER$CS)


# boxplot 
boxplot(CD$CS, ER$CS, 
#range = 1.5,
#xlim = c(0.5, 3.5), 
#ylim = c(0, 35)
boxwex = 0.25,
names=c("CD", "ER"), 
main="boxplot of F-measure for CD and ER",
#xlab="(a)", 
outline = TRUE, col = "gray")


#### interaction plot of FM considering TREAT and TASK  
par(cex=1)
interaction.plot(dati$METHOD, dati$ABILITY, dati$CS, trace.label = "ABIBILITY", 
xlab = "METHOD", ylab = "Mean of F-measure",   ylim = c(0, 1),
cex.axis=1.5, cex.lab=1.5, cex.main=1.5)

an <- anova(lm(CS ~ METHOD*SYSTEM*LAB, dati))
an

################# statistical significance difference

t.test(CD$CS, ER$CS, alternative="two.side", paired = TRUE, conf.level = 0.95)

#################

wilcox.test(CD$CS, ER$CS, alternative="two.side", paired = TRUE, conf.level = 0.95)
### paired=FALSE for Mann-Whitney test


################# effect size

VD.A(CD$CS, ER$CS)

cliff.delta(CD$CS, ER$CS)

##############################################################################################


################# statistical power 
sdd <- sd(CD$CS - ER$CS)
delta <- abs(mean(CD$CS) - mean(ER$CS)) 

power.t.test(n=length(CD$CS), delta, sdd, sig.level=0.05, power=NULL,
             type="one.sample",
             alternative="two.sided") 

################# statistical power 

mean1<- mean(CD$CS)
mean2<-mean(ER$CS)
sd1<-sd(CD$CS)
sd2<-sd(ER$CS)
size<-length(CD$CS)
pval <- replicate(1000, wilcox.test(rnorm(size,mean1,sd1), rnorm(size,mean2,sd2))$p.value)
summary(pval)
sum(pval<.05)


################################################################################
################################################################################

library(car)
library(graphics)
library (sm)
library(BSDA)
library(tseries)
library(lmtest)
library(MASS)
library(nortest)
library(e1071)
library(SiZer)
library(exactRankTests)
library(lmPerm)
library(effsize)

################################################################################
################################################################################
######## Building regression models
################################################################################


## caricare il dataset

dati <- read.table("/Users/carmine/Library/CloudStorage/OneDrive-UniversitàdiSalerno/CORSI/MQS - Software Metrics, Analytics, and Quality/LEZIONI/L10-3 Dataset Nasa.csv", header = TRUE, sep = ";", dec = ".")

## per filtrare il dataset
dati <- dati[which(dati["EFFORT"] < 1000),]

## le variabili che utilizzo Dep= dipendente Ind=indipendente
Dep<-dati$EFFORT				
Ind<-dati$TotalLines				

## test per la normalità della distribuzione
shapiro.test(Dep)      
shapiro.test(Ind)

# boxplot 
boxplot(dati$TotalLines, dati$EFFORT	, 
#range = 1.5,
#xlim = c(0.5, 3.5), 
#ylim = c(0, 35)
boxwex = 0.25,
names=c("Ind", "Dep"), 
main="boxplot of Ind e Dep",
#xlab="(a)", 
outline = TRUE, col = "gray")

### pearson correlation
corre <- cor.test(Ind, Dep, alternative = c("two.sided"), method = c("pearson"), exact = NULL, conf.level = 0.95)
corre

# test di linearità
sm.regression(Ind, Dep, h=300,model="linear",test=TRUE, xlab="TotalLines", ylab="EFFORT")
text(Ind, Dep)

### TotalLines vs EFFORT  

# perform Breusch-Pagan test per l'omoschedasticità
# bptest(res)
bptest(Dep ~ Ind)

# simple linear regression per costtuire il modello con una 1 variabile indipendente
fm <- lm(Dep ~ Ind)
summary(fm)
# normalità dei residui ottenuti con il modello 
shapiro.test(resid(fm))

dw<-dwtest(fm,data=dati) ## test di Durbin-Watson
dw
# The Durbin-Watson statistic is used to test for the presence of serial correlation 
# among the residuals. The value of the Durbin-Watson statistic ranges from 0 to 4. 
# As a general rule of thumb, the residuals are not correlated if the Durbin-Watson 
# statistic is approximately 2, and an acceptable range is 1.50 - 2.50. 

### analisi degli outliers

# distanza di cook
cooks.distance(fm)

## plottando i residui
plot(fitted(fm), resid(fm),
  xlab="Fitted values",
  ylab="Residuals", 
main="Scatter plot of Residuals"
)
text(fitted(fm), resid(fm))



############

# multiple linear regression per costtuire il modello con più variabili indipendenti (3 nell'esempio sotto)

Dep<-dati$EFFORT				
Ind1<-dati$Methodology
Ind2<-dati$Complexity
Ind3<-dati$Experience
Ind4<-dati$DevelopedLines


fm <- lm(Dep ~ Ind1+Ind2+Ind3+Ind4)
summary(fm)

############

# stepwise linear regression 
# Dep= variabile dipendente; Ind1, Ind2, Ind3, Ind4 variabili indipendenti
fm <- lm(data=dati, Dep   ~ Ind1  + Ind2 + Ind3  + Ind4)
summary(fm)

summary(fm)
stepsel <-step(fm, direction="both")
formulas <-  stepsel$call$formula   ### restituisce la formula con le variabili selezionate
formu <- toString(formulas)
cat("Formula: ", formu, "\n")


fm <- lm(data=dati, Dep   ~ Ind1  + Ind2 + Ind4)
summary(fm)

fm <- lm(data=dati, Dep   ~ Ind2 + Ind4)
summary(fm)
