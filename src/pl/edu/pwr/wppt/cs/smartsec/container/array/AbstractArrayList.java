package pl.edu.pwr.wppt.cs.smartsec.container.array;

import java.util.Iterator;

import pl.edu.pwr.wppt.cs.smartsec.memory.Endian;

public abstract class AbstractArrayList implements Iterable {

	protected short indexFirst;
	protected short indexOutOfBounds;
	protected final IndexCalculator indexCalculator;
	protected final Itr iterator;

	protected AbstractArrayList() {
		this(Endian.NATIVE);
	}

	protected AbstractArrayList(Endian endian) {
		iterator = new Itr();
		if (endian == Endian.LITTLE) {
			indexCalculator = ArrayIteratorIndexInc.getInstance();
			indexFirst = 0;
			indexOutOfBounds = AbstractArrayList.this.size();
		} else {
			indexCalculator = ArrayIteratorIndexDec.getInstance();
			indexFirst = (short) (AbstractArrayList.this.size() - 1);
			indexOutOfBounds = -1;
		}
	}

	public abstract short size();

	public abstract Object get(short index);

	public abstract Object set(short index, Object element);

	public abstract boolean add(Object element);

	public void reverse() {
		throw new UnsupportedOperationException();
	}

	public Object getArray() {
		throw new UnsupportedOperationException();
	}

	public Iterator iterator() {
		return (Iterator) iterator.clone();
	}

	protected class Itr implements Iterator, Cloneable {

		protected short indexNext;

		public Itr() {
			indexNext = indexFirst;
		}

		public boolean hasNext() {
			if (indexNext == indexOutOfBounds)
				return false;
			return true;
		}

		public void reset() {
			indexNext = indexFirst;
		}

		public Object next() {
			Object nextReference = AbstractArrayList.this.get(indexNext);
			indexNext = indexCalculator.nextIndex(indexNext);
			return nextReference;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Object clone() { // JDK 1.4 doesnt't allow to override return
								// type
			try {
				return (Itr) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException();
			}
		}
	}

	protected static interface IndexCalculator {
		public short nextIndex(short i);
	}

	private static class ArrayIteratorIndexInc implements IndexCalculator {

		private static final ArrayIteratorIndexInc instance = new ArrayIteratorIndexInc();

		private ArrayIteratorIndexInc() {
		}

		public static ArrayIteratorIndexInc getInstance() {
			return instance;
		}

		public short nextIndex(short i) {
			return ++i;
		}
	}

	private static class ArrayIteratorIndexDec implements IndexCalculator {

		private static final ArrayIteratorIndexDec instance = new ArrayIteratorIndexDec();

		private ArrayIteratorIndexDec() {
		}

		public static ArrayIteratorIndexDec getInstance() {
			return instance;
		}

		public short nextIndex(short i) {
			return --i;
		}
	}
}
