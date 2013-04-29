package bar;

/**
 * a simple commandline progress bar
 * @author philip
 *
 */
public class ProgressBar {

	private int capacity; // capacity of the bar, i.e., what value constitutes 100%
	private int size; // length of the bar, i.e., how many characters it is comprised of
	
	public ProgressBar (int capacity, int size) {
		this.capacity = capacity;
		this.size = size;
		this.update(0);
	}
	
	/**
	 * update the progress bar with a new value
	 * @param progress new value for the progress
	 */
	public void update(double progress) {
		// calculate the necessary number of "#" to add to the bar
		double marks = (progress/this.capacity) * this.size;
		
		// build the bar
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");

		for(int i = 1; i <= marks; i++) {
			buffer.append("#");
		}
		for(int i = this.size; i > marks; i--) {
			buffer.append(" ");
		}
		buffer.append("] " + (int)progress + "/" + this.capacity + "\r");
		System.out.print(buffer.toString());
	}
	
	/**
	 * when done, call this to move the cursor to a new line
	 */
	public void finish() {
		System.out.println();
	}
}
