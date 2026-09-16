
public class ContractViolationsDemo {
    public static void main(String[] args) {
        // This should fail under RAC because divisor is 0
        System.out.println("About to violate a precondition...\n");
        System.out.flush();
        System.out.println(MaxUtils.safeDiv(5, 0));
    }
}
