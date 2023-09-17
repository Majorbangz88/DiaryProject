import Data.Models.Diary;
import Data.Repositories.DiaryRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {

    DiaryRepositoryImpl updatedDiary = new DiaryRepositoryImpl();
    public void setup() {
        updatedDiary = new DiaryRepositoryImpl();
    }

    @Test public void testThatDiaryCanIncrementWhenAdded() {
        Diary newDiary = new Diary();
        updatedDiary.save(newDiary);
        assertEquals(1, updatedDiary.count());

        Diary diary = new Diary();
        updatedDiary.save(diary);
        assertEquals(2, updatedDiary.count());
    }

    @Test public void testThatDiaryCanSetAndUpdateUsername() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertEquals("esther", updatedDiary.findById(1).getUsername());

        Diary anotherNewDiary = new Diary();
        anotherNewDiary.setId(1);
        anotherNewDiary.setUsername("americana");
        updatedDiary.save(anotherNewDiary);
        assertEquals("americana", updatedDiary.findById(1).getUsername());
    }

    @Test public void testThatWhenDiaryIsDeleted_it_is_deleted() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertEquals("esther", updatedDiary.findById(1).getUsername());

        Diary yetNewDiary = new Diary();
        yetNewDiary.setUsername("americana");
        updatedDiary.save(yetNewDiary);
        assertEquals("americana", updatedDiary.findById(2).getUsername());

        updatedDiary.delete(yetNewDiary);
        assertNull(updatedDiary.findById(2));

        updatedDiary.delete(newDiary);
        assertNull(updatedDiary.findById(1));
        System.out.println(updatedDiary.findAll());
    }

    @Test public void testThatListReturnsAllContent() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertEquals("esther", updatedDiary.findById(1).getUsername());

        Diary yetNewDiary = new Diary();
        yetNewDiary.setUsername("americana");
        updatedDiary.save(yetNewDiary);
        assertEquals("americana", updatedDiary.findById(2).getUsername());

        Iterable<Diary> listContent = List.of(new Diary[]{newDiary, yetNewDiary});
        assertEquals(listContent, updatedDiary.findAll());
    }

    @Test public void testThatContentOfListClears() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertEquals("esther", updatedDiary.findById(1).getUsername());

        Diary yetNewDiary = new Diary();
        yetNewDiary.setUsername("americana");
        updatedDiary.save(yetNewDiary);
        assertEquals("americana", updatedDiary.findById(2).getUsername());

        Iterable<Diary> listContent = List.of(new Diary[]{newDiary, yetNewDiary});
        assertEquals(listContent, updatedDiary.findAll());

        updatedDiary.clear();
        assertEquals(0,updatedDiary.count());
    }

    @Test public void testThatDiaryIsNullIfWrongId() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertNull(updatedDiary.findById(5));

        Diary yetNewDiary = new Diary();
        yetNewDiary.setUsername("americana");
        updatedDiary.save(yetNewDiary);
        assertNull(updatedDiary.findById(3));
    }

    @Test public void testThatDeleteDiaryReducesCount() {
        Diary newDiary = new Diary();
        newDiary.setUsername("esther");
        updatedDiary.save(newDiary);
        assertEquals("esther", updatedDiary.findById(1).getUsername());

        Diary yetNewDiary = new Diary();
        yetNewDiary.setUsername("americana");
        updatedDiary.save(yetNewDiary);
        assertEquals("americana", updatedDiary.findById(2).getUsername());

        updatedDiary.delete(yetNewDiary);
        assertNull(updatedDiary.findById(2));

        assertEquals(1,updatedDiary.count());
    }

}
