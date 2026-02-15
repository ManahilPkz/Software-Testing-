package bllTesting;

import bll.IEditorBO;
import dto.Documents;
import java.io.File;
import java.util.*;

public class DummyEditorBO implements IEditorBO {

    @Override
    public boolean createFile(String nameOfFile, String content) {
        return true;
    }

    @Override
    public boolean updateFile(int id, String fileName, int pageNumber, String content) {
        return true;
    }

    @Override
    public boolean deleteFile(int id) {
        return true;
    }

    @Override
    public boolean importTextFiles(File file, String fileName) {
        return true;
    }

    @Override
    public Documents getFile(int id) {
        return null;
    }

    @Override
    public List<Documents> getAllFiles() {
        return new ArrayList<>();
    }

    @Override
    public String getFileExtension(String fileName) {
        return "txt";
    }

    @Override
    public String transliterate(int pageId, String arabicText) {
        return "translated";
    }

    @Override
    public List<String> searchKeyword(String keyword) {
        return new ArrayList<>();
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
        return 2.0;
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
