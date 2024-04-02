/*
 * Doubly Linked List node.
 */
public class DLLNode<T>
{
	private T elem;
	private DLLNode<T> forward;
	private DLLNode<T> back;

	public DLLNode(T elem)
	{
		this.elem = elem;
		forward = null;
		back = null;
	}

	public void setElement(T elem)
	{
		this.elem = elem;
	}

	public T getElement()
	{
		return elem;
	}

	public void setForward(DLLNode<T> forward)
	{
		this.forward = forward;
	}

	public void setBack(DLLNode<T> back)
	{
		this.back = back;
	}

	public DLLNode<T> getForward()
	{
		return forward;
	}

	public DLLNode<T> getBack()
	{
		return back;
	}
}
