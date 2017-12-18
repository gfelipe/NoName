package br.uff.service;

import br.uff.model.Bibliography;
import br.uff.repository.BibliographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CompositeIterator;

import java.util.List;

@Service
public class BibliographyService {
    @Autowired
    private BibliographyRepository bibliographyRepository;

    public void save(Bibliography bibliography){
        try{
            bibliographyRepository.save(bibliography);
        }catch (Exception e){

        }
    }

    public void delete(Long id){
        try{
            bibliographyRepository.delete(id);
        } catch (Exception e){

        }
    }

    public List<Bibliography> getAllByAuthor(String author){
        String authorFilter = author.isEmpty() ? "%" : author.toString();
        return bibliographyRepository.findAllByAuthorContaining(authorFilter);
    }
}
