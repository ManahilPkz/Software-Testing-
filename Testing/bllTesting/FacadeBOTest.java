package bllTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import bll.FacadeBO;
import bll.IEditorBO;

class FacadeBOTest {

    @Test
    void testCreateFile() {

        IEditorBO dummyBO = new DummyEditorBO();
        FacadeBO facade = new FacadeBO(dummyBO);

        boolean result = facade.createFile("test.txt", "hello");

        assertTrue(result);
    }
}

