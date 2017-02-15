package coursera.week2.stackqueue;

/**
 * Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum
 * operation. Assume the elements are reals numbers so that you can compare them.
 */
public class StackWithMax extends ArrayStack<Double> {

    private Stack<Double> maxValueStack = new ArrayStack<>();

    @Override
    public void push(Double element) {
        if(maxValueStack.isEmpty() || maxValueStack.peek() <= element)
            maxValueStack.push(element);

        super.push(element);
    }

    @Override
    public Double pop() {
        Double element = super.pop();
        if(element == maxValueStack.peek())
            maxValueStack.pop();

        return element;
    }

    public double max() {
        return maxValueStack.peek();
    }

}
