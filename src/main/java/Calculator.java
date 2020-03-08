public class Calculator {
    private StringBuilder result;
    private StringBuilder target;
    // 0 -> add
    // 1 -> sub
    // 2 -> mul
    // 3 -> div
    private int option;
    private boolean isInput;

    public int getOption() {
        return option;
    }
    public String getResult() {
        return result.toString();
    }
    public String getTarget() {
        return target.toString();
    }

    public Calculator() {
        result = new StringBuilder("0");
        isInput = false;
        target = new StringBuilder("0");
        option = -1;
    }


    public String setTarget(int target) {
        if(!isInput) {
            this.target = new StringBuilder("0");
            isInput = true;
        }
        if(this.target.toString().equals("0")) {
            this.target = new StringBuilder(String.valueOf(target));
        }
        else {
            this.target.append(target);
        }
        return this.target.toString();
    }

    public String point() {
        if(this.target.toString().endsWith(".")) {
            return this.target.toString();
        }
        this.target.append(".");
        isInput = true;
        return this.target.toString();
    }

    public String calLogic(int option) {
        if(isInput) {
            isInput = false;
            calculate();
            target = new StringBuilder("0");
        }
        else {
            calculate();
        }
        this.option = option;
        return this.result.toString();
    }

    public void ac() {
        this.target = new StringBuilder("0");
        this.result = new StringBuilder("0");
        this.option = -1;
        isInput = false;
    }

    private void calculate() {
        double result_value;
        double target_value;
        try {
             result_value = Double.parseDouble(result.toString());
             target_value = Double.parseDouble(target.toString());
            switch (this.option) {
                case 0:
                    result_value += target_value;
                    break;
                case 1:
                    result_value -= target_value;
                    break;
                case 2:
                    result_value *= target_value;
                    break;
                case 3:
                    result_value /= target_value;
                    break;
            }

            if(isInteger(result_value)) {
                result = new StringBuilder(String.valueOf((int)result_value));
            }
            else {
                result = new StringBuilder(String.valueOf(result_value));
            }
        } catch (IndexOutOfBoundsException e) {
            ac();
            result = new StringBuilder(e.toString());
        }
    }

    public String result() {
        if(isInput) {
            calculate();
            isInput = false;
        }
        else {
            calculate();
        }
        return result.toString();
    }

    public boolean isInteger(Double d)
    {
        return (d == Math.floor(d)) && (!Double.isInfinite(d));
    }
}
