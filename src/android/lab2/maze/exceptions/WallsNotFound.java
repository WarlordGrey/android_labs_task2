package android.lab2.maze.exceptions;

public class WallsNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WallsNotFound() {
		super();
	}

	public WallsNotFound(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public WallsNotFound(String detailMessage) {
		super(detailMessage);
	}

	public WallsNotFound(Throwable throwable) {
		super(throwable);
	}

}
