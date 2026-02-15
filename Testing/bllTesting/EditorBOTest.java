package bllTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bll.EditorBO;
import dal.IFacadeDAO;
import dto.Documents;

class EditorBOTest {

    private EditorBO editor;
    private FakeDAO fakeDAO;

    // Fake DAO implementation for testing
    class FakeDAO implements IFacadeDAO {

        boolean createResult = true;
        boolean updateResult = true;
        boolean deleteResult = true;

        @Override
        public boolean createFileInDB(String name, String content) {
            return createResult;
        }

        @Override
        public boolean updateFileInDB(int id, String name, int page, String content) {
            return updateResult;
        }

        @Override
        public boolean deleteFileInDB(int id) {
            return deleteResult;
        }

        @Override
        public List<Documents> getFilesFromDB() {
            return new ArrayList<>();
        }

        // Remaining methods return dummy values

        @Override public String transliterateInDB(int pageId, String text) { return "done"; }
        @Override public java.util.Map<String,String> lemmatizeWords(String text){ return null; }
        @Override public java.util.Map<String,java.util.List<String>> extractPOS(String text){ return null; }
        @Override public java.util.Map<String,String> extractRoots(String text){ return null; }
        @Override public double performTFIDF(List<String> a, String b){ return 0.5; }
        @Override public java.util.Map<String,Double> performPMI(String content){ return null; }
        @Override public java.util.Map<String,Double> performPKL(String content){ return null; }
        @Override public java.util.Map<String,String> stemWords(String text){ return null; }
        @Override public java.util.Map<String,String> segmentWords(String text){ return null; }
    }

    @BeforeEach
    void setup() {
        fakeDAO = new FakeDAO();
        editor = new EditorBO(fakeDAO);
    }

    @Test
    void testCreateFile_Success() {
        boolean result = editor.createFile("Test", "Hello World");
    }

    @Test
    void testGetFileExtension() {
        String ext = editor.getFileExtension("file.txt");
        assertEquals("txt", ext);
    }

    @Test
    void testGetFileExtension_NoExtension() {
        String ext = editor.getFileExtension("file");
        assertEquals("", ext);
    }
}
