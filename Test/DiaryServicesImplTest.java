import Data.Models.Diary;
import Services.DiaryServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiaryServicesImplTest {

    DiaryServicesImpl diaryServicesimpl;
    @BeforeEach
    public void setup() {
        diaryServicesimpl = new DiaryServicesImpl();
    }

    @Test public void testThatUserCanRegister() {
        diaryServicesimpl.register("username", "password");
        assertEquals(1, diaryServicesimpl.count());

        diaryServicesimpl.register("americana", "password");
        assertEquals(2, diaryServicesimpl.count());
    }

    @Test public void testThatUsername_Is_Unique_And_Throws_Exception_If_not_unique() {
        diaryServicesimpl.register("username", "password");
        assertThrows(IllegalArgumentException.class,
                ()-> {diaryServicesimpl.register("username", "password");});
        assertEquals(1, diaryServicesimpl.count());
    }

    @Test public void testThat_User_Can_Be_found_using_username() {
        diaryServicesimpl.register("username", "password");
        assertEquals(1, diaryServicesimpl.count());

        Diary foundUser = diaryServicesimpl.findByUsername("username");
        assertEquals("username", foundUser.getUsername());
    }

    @Test public void testThat_User_Can_Be_Deleted() {
        diaryServicesimpl.register("username", "password");
        assertEquals(1, diaryServicesimpl.count());

        diaryServicesimpl.register("americana", "password");
        assertEquals(2, diaryServicesimpl.count());

        diaryServicesimpl.delete("americana", "password");
        assertEquals(1, diaryServicesimpl.count());
    }
}
