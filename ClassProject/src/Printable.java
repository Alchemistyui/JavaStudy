
public interface Printable {

	void print();

}

interface Moveable {
	void move();
}

interface PrintAndMoveAble extends Printable, Moveable {

}