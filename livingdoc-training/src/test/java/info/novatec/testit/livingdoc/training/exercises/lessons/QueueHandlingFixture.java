package info.novatec.testit.livingdoc.training.exercises.lessons;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;


@FixtureClass("Queue Handling")
public class QueueHandlingFixture {

    private static final Logger log = LoggerFactory.getLogger(QueueHandlingFixture.class);

    private Queue<Object> queue;

    @BeforeTable
    public void reset() {
        queue = null;
    }

    @Alias("a new queue was created")
    public boolean createQueue() {
        queue = new LinkedList<>();
        return true;
    }

    @Alias("the queue size is")
    public Integer checkSize() {
        return queue.size();
    }

    @Alias("an element is added to the queue")
    public boolean addElement() {
        queue.add(new Object());
        return true;
    }

    @Alias("the queue is polled")
    public boolean pollQueue() {
        queue.poll();
        return true;
    }

    @Alias("the queue is empty")
    public boolean isEmpty() {
        boolean result = queue.isEmpty();
        if (!result) {
            log.error("expected queue to be empty but it has {} elements", queue.size());
        }
        return result;
    }

}
