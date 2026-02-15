package bllTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bll.SearchWord;
import dto.Documents;
import dto.Pages;

public class SearchWordTest {

    @Test
    void testSearchKeyword_Found() {

        Pages page = new Pages(
                1,          // pageId
                1,          // fileId
                1,          // pageNumber
                "Java is very easy language"
        );

        List<Pages> pagesList = new ArrayList<>();
        pagesList.add(page);

        Documents doc = new Documents(
                1,
                "Doc1",
                "hash123",
                "2024-01-01",
                "2024-01-01",
                pagesList
        );

        List<Documents> docsList = new ArrayList<>();
        docsList.add(doc);

        List<String> result = SearchWord.searchKeyword("easy", docsList);

        assertEquals(1, result.size());
        assertTrue(result.get(0).contains("Doc1"));
    }

    @Test
    void testSearchKeyword_NotFound() {

        Pages page = new Pages(
                1, 1, 1,
                "Java is very easy language"
        );

        List<Pages> pagesList = new ArrayList<>();
        pagesList.add(page);

        Documents doc = new Documents(
                1,
                "Doc1",
                "hash123",
                "2024-01-01",
                "2024-01-01",
                pagesList
        );

        List<Documents> docsList = new ArrayList<>();
        docsList.add(doc);

        List<String> result = SearchWord.searchKeyword("Python", docsList);

        assertEquals(0, result.size());
    }

    @Test
    void testSearchKeyword_ShortKeyword() {

        List<Documents> docsList = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> {
            SearchWord.searchKeyword("ab", docsList);
        });
    }

    @Test
    void testSearchKeyword_MultipleDocuments() {

        Pages page1 = new Pages(
                1, 1, 1,
                "Java is powerful"
        );

        Pages page2 = new Pages(
                2, 2, 1,
                "Python is also powerful"
        );

        List<Pages> pages1 = new ArrayList<>();
        pages1.add(page1);

        List<Pages> pages2 = new ArrayList<>();
        pages2.add(page2);

        Documents doc1 = new Documents(
                1,
                "Doc1",
                "hash1",
                "2024-01-01",
                "2024-01-01",
                pages1
        );

        Documents doc2 = new Documents(
                2,
                "Doc2",
                "hash2",
                "2024-01-01",
                "2024-01-01",
                pages2
        );

        List<Documents> docsList = new ArrayList<>();
        docsList.add(doc1);
        docsList.add(doc2);

        List<String> result = SearchWord.searchKeyword("powerful", docsList);

        assertEquals(2, result.size());
    }
}
