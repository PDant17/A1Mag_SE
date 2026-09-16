
#!/usr/bin/env bash
set -euo pipefail

openjml -esc 01-basics/*.java
openjml -esc 02-bankaccount/*.java
openjml -esc 03-assignable-frames/*.java
openjml -esc 04-loops/*.java
openjml -esc 05-model-ghost/*.java

mkdir -p bin
openjml -rac -d bin 01-basics/*.java 02-bankaccount/*.java 03-assignable-frames/*.java 04-loops/*.java 05-model-ghost/*.java 2>&1 | tee rac.log
