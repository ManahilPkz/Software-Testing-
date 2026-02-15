package bllTesting;

import dal.IFacadeDAO;
import dto.Documents;
import java.util.*;

public class DummyDAO implements IFacadeDAO {

    @Override
    public boolean createFileInDB(String nameOfFile, String content) {
        return true;
    }

    @Override
    public boolean updateFileInDB(int id, String fileName, int pageNumber, String content) {
        return true;
    }

    @Override
    public boolean deleteFileInDB(int id) {
        return true;
    }

    @Override
    public List<Documents> getFilesFromDB() {
        return new ArrayList<>();
    }

    @Override
    public String transliterateInDB(int pageId, String arabicText) {
        return "translated";
    }

    @Override
    public Map<String, String> lemmatizeWords(String text) {
        return new HashMap<>();
    }

    @Override
    public Map<String, List<String>> extractPOS(String text) {
        return new HashMap<>();
    }

    @Override
    public Map<String, String> extractRoots(String text) {
        return new HashMap<>();
    }

    @Override
    public double performTFIDF(List<String> unSelectedDocsContent, String selectedDocContent) {
        return 1.5;
    }

    @Override
    public Map<String, Double> performPMI(String content) {
        return new HashMap<>();
    }

    @Override
    public Map<String, Double> performPKL(String content) {
        return new HashMap<>();
    }

    @Override
    public Map<String, String> stemWords(String text) {
        return new HashMap<>();
    }

    @Override
    public Map<String, String> segmentWords(String text) {
        return new HashMap<>();
    }
}

