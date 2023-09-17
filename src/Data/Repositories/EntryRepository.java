package Data.Repositories;

import Data.Models.Diary;
import Data.Models.Entry;

public interface EntryRepository {

    Entry save(Entry entry);
    void delete(Diary diary);
    long count();
    Entry findById(int id);
    Iterable<Entry> findAll();
    void clear();
}
