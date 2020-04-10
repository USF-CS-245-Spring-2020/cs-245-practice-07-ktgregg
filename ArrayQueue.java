public class ArrayQueue<T> implements Queue<T>
{
	private final int DEFAULT_SIZE = 10;
	private T[] array;
	private int front;
	private int back;
	private int numItems;

	// constructor, initializes variables
	public ArrayQueue(){
		front = 0;
		back = -1;
		numItems = 0;
		array = (T[])new Object[DEFAULT_SIZE];
	}

	// removes top element
	public T dequeue() throws Exception
	{
		// if there's nothing in the queue, an error is thrown
		if(numItems == 0)
		{
			throw new Exception("Unable to Dequeue. Queue is empty");
		}
		numItems--;
		return array[front++];
	}

	// adds a new element
	public void enqueue(T item)
	{
		// if the array size "maxes out" its size, double its size
		if(numItems == array.length)
		{
			doubleArraySize();
			array[++back] = item;
		}
		else
		{
			array[++back % array.length] = item;
		}
		numItems++;
	}

	// returns true if queue is empty, false otherwise
	public boolean empty()
	{
		return numItems == 0;
	}

	// doubles size of the array to make space for new elements
	protected void doubleArraySize()
	{
		int newLength = array.length * 2;
		T[] temp = (T[])new Object[newLength];
		for(int i = 0; i < numItems; i++)
		{
			temp[i] = array[i];
		}
		array = temp;
	}

}