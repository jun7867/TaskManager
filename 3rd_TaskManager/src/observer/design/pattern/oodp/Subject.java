package observer.design.pattern.oodp;

public interface Subject {
	
	void subscribe(Observer o);

    void unSubscribe(Observer o);

    void alarm();

}
