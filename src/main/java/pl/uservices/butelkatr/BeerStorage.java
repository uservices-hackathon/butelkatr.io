package pl.uservices.butelkatr;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import com.google.common.base.Optional;


@Component
public class BeerStorage {
	
	private static final int MIN = 100;
	
	private  Queue<Integer> beerQuantityQueue = new ConcurrentLinkedQueue<>();
	
	private  AtomicLong beerQuantitySum = new AtomicLong(0);
	
	private AtomicLong beerProcessed = new AtomicLong(0);
	
	public  void addBeer(Integer quantity)
	{
		beerQuantityQueue.offer(quantity);
		beerQuantitySum.addAndGet(quantity);
		beerProcessed.addAndGet(quantity);
	}
	
	public synchronized Optional<Integer> getBeer()
	{
		if(beerQuantitySum.get() < MIN) return Optional.absent();
		
		Integer beerQuantity = 0;
		do{
			beerQuantity += beerQuantityQueue.poll();
			beerQuantitySum.addAndGet(-beerQuantity);
		}while(beerQuantity < MIN);
		
		return Optional.of(beerQuantity);
	}
	
	public long getTotalBeer(){
		return beerQuantitySum.get();
	}
	
	public  int getQueueSize(){
		return beerQuantityQueue.size();
	}
	
	public long getTotalBeerProcessed(){
		return beerProcessed.get();
	}
	
}
