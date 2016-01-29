package com.example.testthreadpool;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import android.util.Log;

/**
 * @author zhangyi
 * 
 *         TODO 使用线程池的demo
 * 
 */
public class MyThreadPools {
	private int p = 0;
	private int c = 0;
	private int size=10;

	class Producer implements Runnable {
		private final BlockingQueue queue;

		Producer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
			try {
				while (p<size) {
					queue.put(produce());
				}
			} catch (InterruptedException ex) {
			}
		}

		Object produce() {
			
			return new String("Producer");
		}
	}

	class Consumer implements Runnable {
		private final BlockingQueue queue;

		Consumer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
			try {
				while (c<size) {
					consume(queue.take());
				}
			} catch (InterruptedException ex) {
			}
		}

		void consume(Object x) {
			
		}
	}

	public class Setup {
		void main() {
			BlockingQueue queue=new LinkedBlockingQueue<Runnable>(){
				@Override
				public Runnable take() throws InterruptedException {
					return super.take();
				}
			};
			
			BlockingQueue q = new BlockingQueue<String>() {

				@Override
				public String remove() {
					return null;
				}

				@Override
				public String poll() {
					return null;
				}

				@Override
				public String element() {
					return null;
				}

				@Override
				public String peek() {
					return null;
				}

				@Override
				public boolean addAll(Collection<? extends String> collection) {
					return false;
				}

				@Override
				public void clear() {

				}

				@Override
				public boolean containsAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean isEmpty() {
					return false;
				}

				@Override
				public Iterator<String> iterator() {
					return null;
				}

				@Override
				public boolean removeAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean retainAll(Collection<?> collection) {
					return false;
				}

				@Override
				public int size() {
					return 0;
				}

				@Override
				public Object[] toArray() {
					return null;
				}

				@Override
				public <T> T[] toArray(T[] array) {
					return null;
				}

				@Override
				public boolean add(String e) {
					return false;
				}

				@Override
				public boolean offer(String e) {
					return false;
				}

				@Override
				public void put(String e) throws InterruptedException {
					LogKT.zy("------queue.put(produce())-----pppppppppp----"+p);
					p++;
				}

				@Override
				public boolean offer(String e, long timeout, TimeUnit unit)
						throws InterruptedException {
					return false;
				}

				@Override
				public String take() throws InterruptedException {
					LogKT.zy("------consume(queue.take())------" + this.toString()+"--------cccccc----"+c);
					c++;
					return null;
				}

				@Override
				public String poll(long timeout, TimeUnit unit)
						throws InterruptedException {
					return null;
				}

				@Override
				public int remainingCapacity() {
					return 0;
				}

				@Override
				public boolean remove(Object o) {
					return false;
				}

				@Override
				public boolean contains(Object o) {
					return false;
				}

				@Override
				public int drainTo(Collection<? super String> c) {
					return 0;
				}

				@Override
				public int drainTo(Collection<? super String> c, int maxElements) {
					return 0;
				}
			};
			Producer p = new Producer(q);
			Consumer c1 = new Consumer(q);
			Consumer c2 = new Consumer(q);
			new Thread(p).start();
			new Thread(c1).start();
			new Thread(c2).start();
		}
	}
}
