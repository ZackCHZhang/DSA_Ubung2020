package de.unistuttgart.vis.dsass2020.ex05.p3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.unistuttgart.vis.dsass2020.ex05.p1.Rectangle;

/**
 * This class represents a two-dimensional collision map. A collision map is a
 * data structure that stores a set of rectangles. Given another rectangle, this
 * data structure allows retrieving all rectangles that intersect this
 * rectangle.
 */
public class CollisionMap {

	// If the resolution of the grid is not specified by the user we use this
	// default resolution.
	private static final int GRID_RESOLUTION_X = 100;
	private static final int GRID_RESOLUTION_Y = 100;

	/**
	 * Rectangle that encapsulates all rectangles in the collision map.
	 */
	public Rectangle gridRectangle;

	/**
	 * A two-dimensional array of {@link java.util.List} serves as the data
	 * structure for storing the rectangles. Each element of the array holds a list
	 * of rectangles. At the same time, each element of the array is associated with
	 * an area of the bounding rectangle {@link CollisionMap.gridRectangle} through
	 * the transform methods ({@link CollisionMap.transformX} and
	 * {@link CollisionMap.transformY}. These areas are called cells.
	 */
	private List<Rectangle>[][] map;

	/**
	 * Creates a {@link CollisionMap} from a set of rectangles.
	 * 
	 * @param rectangles that are placed in the collision map
	 * @throws CollisionMapException
	 */
	public CollisionMap(Set<Rectangle> rectangles) throws IllegalArgumentException {
		this(rectangles, GRID_RESOLUTION_X, GRID_RESOLUTION_Y);
	}

	/**
	 * Creates a {@link CollisionMap} from a set of rectangles and specified grid
	 * resolutions.
	 * 
	 * @param rectangles      that are placed in the collision map
	 * @param gridResolutionX
	 * @param gridResolutionY
	 * @throws CollisionMapException
	 */
	public CollisionMap(Set<Rectangle> rectangles, int gridResolutionX, int gridResolutionY)
			throws IllegalArgumentException {
		if (rectangles == null || gridResolutionX < 1 || gridResolutionY < 1) {
			throw new IllegalArgumentException();
		}
		gridRectangle = Rectangle.getBoundingBox(rectangles);
		generateCollisionMap(gridResolutionX, gridResolutionY);
		try {
			fillCollisionMap(rectangles);
		} catch (CollisionMapOutOfBoundsException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Given a rectangle, this method returns a set of potential colliding
	 * rectangles.
	 * 
	 * @return
	 * @throws CollisionMapOutOfBoundsException
	 */
	public Set<Rectangle> getCollisionCandidates(Rectangle rectangle) throws CollisionMapOutOfBoundsException {
		// TODO Insert code for assignment 5.3.b
		Set<Rectangle> result = new HashSet<Rectangle>();
		for (List<Rectangle>[] iterRectListX : this.map) {
			for (List<Rectangle> iterRectListY : iterRectListX) {
				for (Rectangle iterRect : iterRectListY) {
					if (iterRect.intersects(rectangle)) {
						result.add(iterRect);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Fill this collision map with a set of rectangles.
	 * 
	 * @param rectangles
	 * @throws CollisionMapOutOfBoundsException
	 */
	private void fillCollisionMap(Set<Rectangle> rectangles) throws CollisionMapOutOfBoundsException {
		// TODO Insert code for assignment 5.3.a
		for (Rectangle iterRect : rectangles) {
			map[(int) transformX(iterRect.x)][(int) transformY(iterRect.y)].add(iterRect);
		}
	}

	/**
	 * Transform a x coordinate from rectangle space to the internal space of the
	 * {@link CollisionMap}. For accessing specific cells of the grid the return
	 * value must be rounded and cast appropriately.
	 * 
	 * @param x coordinate of a point
	 * @return x coordinate of given point in the internal space
	 * @throws CollisionMapOutOfBoundsException
	 */
	private float transformX(float x) throws CollisionMapOutOfBoundsException {
		if (x < gridRectangle.x || x > gridRectangle.x + gridRectangle.width) {
			throw new CollisionMapOutOfBoundsException("x coordinate is outside the defined range.");
		} else {
			return ((x - gridRectangle.x) / gridRectangle.width) * map[0].length;
		}
	}

	/**
	 * Transform a y coordinate from rectangle space to the internal space of the
	 * {@link CollisionMap}. For accessing specific cells of the grid the return
	 * value must be rounded and cast appropriately.
	 * 
	 * @param y coordinate of a point
	 * @return y coordinate of given point in the internal space
	 * @throws CollisionMapOutOfBoundsException
	 */
	private float transformY(float y) throws CollisionMapOutOfBoundsException {
		if (y < gridRectangle.y || y > gridRectangle.y + gridRectangle.height) {
			throw new CollisionMapOutOfBoundsException("y coordinate is outside the defined range.");
		} else {
			return ((y - gridRectangle.y) / gridRectangle.height) * map.length;
		}
	}

	/**
	 * @param rectangle
	 * @return true iff the given rectangle intersects one of the rectangles in the
	 *         collision map.
	 * @throws CollisionMapOutOfBoundsException 
	 */
	public boolean collide(Rectangle rectangle) throws CollisionMapOutOfBoundsException {
		// TODO Insert code for assignment 5.3.c
		Set<Rectangle> result = new HashSet<Rectangle>();
		result = this.getCollisionCandidates(rectangle);

		return !result.isEmpty();
	}

	/**
	 * Allocate the collision map
	 * 
	 * @param gridResolutionX
	 * @param gridResolutionY
	 */
	@SuppressWarnings("unchecked")
	private void generateCollisionMap(int gridResolutionX, int gridResolutionY) {
		map = new ArrayList[gridResolutionY][gridResolutionX];
		for (int y = 0; y < gridResolutionY; ++y) {
			for (int x = 0; x < gridResolutionX; ++x) {
				map[y][x] = new ArrayList<Rectangle>();
			}
		}
	}
}
