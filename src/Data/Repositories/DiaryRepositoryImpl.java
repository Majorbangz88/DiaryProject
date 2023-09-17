package Data.Repositories;

import Data.Models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{


    private final List<Diary> myNewDiary = new ArrayList<>();
    @Override
    public Diary save(Diary diary) {
        if (diary.getId() == 0) {
            diary.setId(generateId());
            myNewDiary.add(diary);
        }
        else {
            update(diary);
        }
        return diary;
    }

    private void update(Diary diary) {
        Diary newDiary = findById(diary.getId());
        newDiary.setUsername(diary.getUsername());
    }

    private int generateId() {
        return myNewDiary.size() + 1;
    }

    @Override
    public void delete(Diary diary) {
        Diary newDiary = findById(diary.getId());
        myNewDiary.remove(newDiary);
    }

    @Override
    public long count() {
        return myNewDiary.size();
    }

    @Override
    public Diary findById(int id) {
        for (Diary diary: myNewDiary) {
            if (diary.getId() == id)
                return diary;
        }
        return null;
    }

    @Override
    public Iterable<Diary> findAll() {
        return myNewDiary;
    }

    @Override
    public void clear() {
        myNewDiary.clear();
    }
}
