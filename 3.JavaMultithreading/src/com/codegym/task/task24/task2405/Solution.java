package com.codegym.task.task24.task2405;

/* 
Black box

*/
public class Solution implements Action {
    public static int actionObjectCount;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! You can make changes here

        public void someAction() {
            //!!!!! All changes must be made only here

            if (param > 0) {
                while(param!=1){
                    System.out.println(param--);
                }
                System.out.println(param);
                new FirstClass() {  //anonymus class
                    @Override
                    public Action getDependentAction() {
                        return null;
                    }
                }.someAction();
                param--;
            }

            if (param <= 0) new SecondClass() { //anonymus class
                @Override
                public void someAction() {
                    sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM).append(param);
                    super.someAction();
                }
            }.someAction();
        }

    };



    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * FirstClass class, someAction method
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = 0
     * The number of created Action objects is 2
     * SecondClass class, someAction method
     * Specific action for anonymous SecondClass, param = -1
     * The number of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("The number of created Action objects is " + actionObjectCount);
    }
}
