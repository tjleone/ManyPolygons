import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

public class PIsotropicGrid extends PIsotropicRectangle {
	
	private int rows;
	private int cols;
	PIsotropicRectangle cell = null;

	public PIsotropicGrid() {
		super(0,0,0,0,1,1);
		init(1, 1);
	}

	public PIsotropicGrid(GPoint pt) {
		super(pt);
		init(1, 1);
	}

	public PIsotropicGrid(GDimension size) {
		super(size);
		init(1, 1);
	}

	public PIsotropicGrid(GRectangle r) {
		super(r);
		init(1, 1);
	}

	public PIsotropicGrid(double width, double height) {
		super(width, height);
		init(1, 1);
	}

	public PIsotropicGrid(GPoint pt, GDimension size) {
		super(pt, size);
		init(1, 1);
	}

	public PIsotropicGrid(double x, double y, double width, double height) {
		super(x, y, width, height);
		init(1, 1);
	}

	public PIsotropicGrid(GRectangle r, double scaleFactor, double aspectRatio) {
		super(r, scaleFactor, aspectRatio);
		init(1, 1);
	}

	public PIsotropicGrid(GRectangle r, double scaleFactor, double aspectRatio, int rows, int cols) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), scaleFactor, aspectRatio, rows, cols);
	}

	public PIsotropicGrid(double x, double y, double width, double height, double scaleFactor, double aspectRatio) {
		super(x, y, width, height, scaleFactor, aspectRatio);
		init(1, 1);
	}

	public PIsotropicGrid(double x, double y, double width, double height, double scaleFactor, double aspectRatio, int rows, int cols) {
		super(x, y, width, height, scaleFactor, aspectRatio);
		init(rows, cols);
	}

//	private void init(double sf, double ar) {
//		resize(recalculateSize(sf, ar));
//	}
	
	private void init(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		cell = new PIsotropicRectangle(0, 0, getWidth()/cols, getHeight()/rows, getScaleFactor(), getAspectRatio());
	}
	
	public GDimension getCellSize() {
		assert cell != null;
		return cell.getSize();
	}
	
	public double getCellWidth() {
		assert cell != null;
		return cell.getWidth();
	}
	
	public double getCellHeight() {
		assert cell != null;
		return cell.getHeight();
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

}
