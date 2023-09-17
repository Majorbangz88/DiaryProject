package Data.Repositories;

import Data.Models.Diary;
import Data.Models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{

    private int count;
    private final List<Entry> diaryEntry = new ArrayList<>();
    @Override
    public Entry save(Entry entry) {
        if (entry.getId() == 0) {
            entry.setId(generateId());
            diaryEntry.add(entry);
        }
        else {
            Entry listEntry = findById(entry.getId());
            listEntry.setOwnerName(entry.getOwnerName());
        }
//        count++;
        return entry;
    }

    private int generateId() {
        return diaryEntry.size() + 1;
    }

    @Override
    public void delete(Diary diary) {

    }

    @Override
    public long count() {
        return diaryEntry.size();
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry: diaryEntry) {
            if (entry.getId() == id)
                return entry;
        }
        return null;
    }

    @Override
    public Iterable<Entry> findAll() {
        return diaryEntry;
    }

    @Override
    public void clear() {
        diaryEntry.clear();
    }
}
