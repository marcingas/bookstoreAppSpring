package pl.marcin.bookstoreAppSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marcin.bookstoreAppSpring.model.BookItem;
import pl.marcin.bookstoreAppSpring.model.Section;
import pl.marcin.bookstoreAppSpring.repository.SectionRepository;
import pl.marcin.bookstoreAppSpring.response.SectionResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SectionController {
    @Autowired
    public SectionRepository sRepository;
    @GetMapping("/sections")
    public List<SectionResponse> getSections() {
        List<Section> sections =  sRepository.findAll();
        List<SectionResponse> list = new ArrayList<>();
        sections.forEach(s->{
            SectionResponse sResponse = new SectionResponse();
            sResponse.setSectionName(s.getName());
            sResponse.setId(s.getId());
            sResponse.setBookItemsTitles(s.getBookItems().
                    stream().map(BookItem::getTitle).
                    collect(Collectors.toList()));
            list.add(sResponse);
        });
        return list;
    }
}
