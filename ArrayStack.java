public class ArrayStack<T> implements Stack<T>
{
	private final int DEFAULT_SIZE = 10;
	private int top;
	private T[] array;

	// constructor
	public ArrayStack()
	{
		// initializes array to the default size
		this.array = (T[])new Object[DEFAULT_SIZE];;
		this.top = 0;
	}

	// adds new element to top
	@Override
	public void push(T item)
	{
		// if the array size "maxes out" its size, double its size
		if(top == array.length)
		{
			doubleArraySize();
		}
		// adds the element to the top
		array[top++] = item;
	}

	// removes and returns the top element
	@Override
	public T pop() throws Exception
	{
		// if there's nothing in the stack, an error is thrown
		if(top == 0)
		{
			throw new Exception("Unable to Pop. Stack is empty");
		}
		return array[--top];
	}

	// returns the top element
	@Override
	public T peek() throws Exception
	{
		// if there's nothing in the stack, an error is thrown
		if(top == 0)
		{
			throw new Exception("Unable to Peek. Stack is empty");
		}
		return array[top];
	}

	// returns true if empty, false otherwise
	@Override
	public boolean empty()
	{
		return top == 0;
	}

	// doubles size of the array to make space for new elements
	protected void doubleArraySize()
	{
		int newLength = top * 2;
		T[] tempArray = (T[])new Object[newLength];
		for(int i = 0; i < top; i++)
		{
			tempArray[i] = array[i];
		}
		array = tempArray;
	}
}
