package android.lab2.maze.exceptions;

public class DiscriminantLessThanZero extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiscriminantLessThanZero() {
	}

	public DiscriminantLessThanZero(String detailMessage) {
		super(detailMessage);
	}

	public DiscriminantLessThanZero(Throwable throwable) {
		super(throwable);
	}

	public DiscriminantLessThanZero(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

}
