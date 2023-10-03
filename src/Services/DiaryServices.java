package Services;

import Data.Models.Diary;

public interface DiaryServices {

    void register(String username, String password);
    long count();
    Diary findByUsername(String username);
    void delete(String username, String password);

}
