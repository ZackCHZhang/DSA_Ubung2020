package de.unistuttgart.vis.dsass2020.ex01.p2;

public class SpeedList<T> implements ISpeedList<T> {
//Class for a Node
	private class Node {
		private T obj;
		private Node next;
		private Node eNext;

		public Node(T obj, Node next, Node eNext) {
			this.obj = obj;
			this.next = next;
			this.eNext = eNext;

		}

		public Node() {
			obj = null;
			next = null;
			eNext = null;
		}

		public void setElement(T obj) {
			this.obj = obj;
		}

		public T getElement() {
			return obj;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void seteNext(Node eNext) {
			this.eNext = eNext;
		}

		public Node getNext() {
			return this.next;
		}

		public Node geteNext() {
			return this.eNext;
		}
	}

	private Node head;

	public SpeedList() {
		head = new Node();
	}

	public int size() {
		Node cur = head;
		int size = 0;
		while (cur.eNext != null) {
			cur = cur.eNext;
			size += 8;
		}
		while (cur.next != null) {
			cur = cur.next;
			size++;
		}
		return size;
	}

	public void prepend(T t) {
		Node s = new Node();
		Node n = new Node(t, head.next, head.eNext);
		head.setNext(n);
		s = head;
		for (int i = 0; i < 8; i++) {
			s = s.next;
			if (s == null) {
				break;
			}
		}
		head.seteNext(s);

	}

	public void append(T t) {
		Node l = new Node();
		l = head;
		int cnt = 0;
		while (l.geteNext() != null) {
			l = l.geteNext();
			cnt += 8;
		}
		while (l.getNext() != null) {
			l = l.getNext();
			cnt++;
		}
		Node newNode = new Node(t, null, null);
		l.setNext(newNode);
		cnt = cnt - 7;
		if (cnt >= 0) {
			Node s = new Node();
			s = head;

			while (s.geteNext() != null && cnt >= 8) {
				s = s.eNext;
				cnt -= 8;
			}
			while (cnt != 0) {
				s = s.next;
				cnt--;
			}
			s.seteNext(newNode);

		}
	}

	public T getElementAt(int pos) throws Exception {
		Node s = new Node();
		s = head;
		if (pos < 0) {
			throw new Exception("Plz Input a positive Number");
		}
		if (pos > this.size()) {
			throw new Exception("Ur pos is bigger than the List Size");
		}
		while (pos > 8) {
			s = s.eNext;
			pos -= 8;
		}
		while (pos >= 0) {
			s = s.next;
			pos -= 1;
		}
		return s.getElement();
	}

}
