package Data.Repositories;

import Data.Models.Diary;

public interface DiaryRepository {

    Diary save(Diary diary);
    void delete(Diary diary);
    long count();
    Diary findById(int id);
    Iterable<Diary> findAll();
    void clear();
}
