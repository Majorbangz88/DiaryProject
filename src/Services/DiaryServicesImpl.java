package Services;

import Data.Models.Diary;
import Data.Repositories.DiaryRepositoryImpl;

public class DiaryServicesImpl implements DiaryServices{

    DiaryRepositoryImpl diaryRepository = new DiaryRepositoryImpl();

    @Override
    public void register(String username, String password) {
        validateUsername(username);
        Diary diary = new Diary();
        diary.setUsername(username);
        diary.setPassword(password);
        diaryRepository.save(diary);
    }

    private void validateUsername(String username){
        for (Diary diary: diaryRepository.findAll()) {
            if (diary.getUsername().equals(username))
                throw new IllegalArgumentException("Username already exists");
        }
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }

    @Override
    public Diary findByUsername(String username) {
//        validateUsername(username);
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equals(username))
                return diary;
        }
        return null;
    }

    @Override
    public void delete(String username, String password) {
        Diary diary = findByUsername(username);
        if (diary.getPassword().equals(password))
            diaryRepository.delete(diary);
    }
}
