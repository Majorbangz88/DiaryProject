import Data.Models.Diary;
import Data.Models.Entry;
import Data.Repositories.EntryRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplTest {

    EntryRepositoryImpl updatedEntry = new EntryRepositoryImpl();

    public void setup() {
        updatedEntry = new EntryRepositoryImpl();
    }

    @Test public void testThatEntryIncrementsWhenAdded() {
        Entry newEntry = new Entry();
        updatedEntry.save(newEntry);

        Entry one = new Entry();
        updatedEntry.save(one);
        assertEquals(2, updatedEntry.count());
    }

    @Test public void testThatDiaryCanSetAndUpdateUsername() {
        Entry newEntry = new Entry();
        newEntry.setOwnerName("esther");
        updatedEntry.save(newEntry);
        assertEquals("esther", updatedEntry.findById(1).getOwnerName());

        Entry yetNewEntry = new Entry();
        yetNewEntry.setId(1);
        yetNewEntry.setOwnerName("joel");
        updatedEntry.save(yetNewEntry);
        assertEquals("joel", updatedEntry.findById(1).getOwnerName());
    }

    @Test public void testThatDiaryReturnsAllEntries() {
        Entry newEntry = new Entry();
        newEntry.setOwnerName("esther");
        updatedEntry.save(newEntry);
        assertEquals("esther", updatedEntry.findById(1).getOwnerName());

        Entry yetNewEntry = new Entry();
        newEntry.setOwnerName("esther");
        updatedEntry.save(yetNewEntry);
        assertEquals("esther", updatedEntry.findById(1).getOwnerName());

        Iterable<Entry> listOfEntries = List.of(new Entry[]{newEntry, yetNewEntry});
        assertEquals(listOfEntries, updatedEntry.findAll());
    }

    @Test public void testThatDiaryCanClearAllEntries() {
        Entry newEntry = new Entry();
        newEntry.setOwnerName("esther");
        updatedEntry.save(newEntry);
        assertEquals("esther", updatedEntry.findById(1).getOwnerName());

        Entry yetNewEntry = new Entry();
        newEntry.setOwnerName("esther");
        updatedEntry.save(yetNewEntry);
        assertEquals("esther", updatedEntry.findById(1).getOwnerName());

//        Iterable<Entry> listOfEntries = List.of(new Entry[]{newEntry, yetNewEntry});
//        assertEquals(listOfEntries, updatedEntry.findAll());

        updatedEntry.clear();
        assertEquals(0, updatedEntry.count());
    }

//    @Test public void
}
