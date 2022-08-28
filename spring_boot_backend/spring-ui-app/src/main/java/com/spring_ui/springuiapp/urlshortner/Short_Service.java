package com.spring_ui.springuiapp.urlshortner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Short_Service {
    private Short_Repository shortRepository;

    @Autowired
    public Short_Service(Short_Repository shortRepository) {
        this.shortRepository = shortRepository;
    }

    public Optional<Short> createShort(ShortCreateRequest shortCreateRequest){
        if (shortCreateRequest.getShortURL() == ""){
            Short lastShort = shortRepository.findTopByOrderByUrlIdDesc();
            if (lastShort != null){
                int uniqueNumber = lastShort.getUrlId() + 1000001;
                shortCreateRequest.setShortURL(numberToString(uniqueNumber));
            } else { 
                shortCreateRequest.setShortURL(numberToString(1000049));
            }
        }

        if(shortRepository.existsByShortURL(shortCreateRequest.getShortURL())){
            throw new BadRequestException("Short URL Exists!");
        }
        System.out.println("Short Request: " + shortCreateRequest.toString());
        Short testShort = shortRepository.save(new Short(shortCreateRequest.getShortURL(), shortCreateRequest.getMainURL()));
        return Optional.ofNullable(testShort);
    }
    public String numberToString(int uniqueNumber){
        List<Integer> list = new ArrayList<Integer>();
        while(uniqueNumber > 0){
            int remainder = uniqueNumber % 62;
            list.add(remainder + 48);
            uniqueNumber = uniqueNumber / 62;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            if (num >=58 && num <= 64) {
                num += 7;
            }
            if (num >= 91 && num <= 96) {
                num += 6;
            }
            char ch = (char) num;
            System.out.println(ch);
            sb.append(ch);
        }
        return sb.toString();
    }



    public Short getShort(String shortURL){
        Short serviceShort = shortRepository.findByShortURL(shortURL)
        .orElseThrow(() -> new NotFoundException("Short URL not found. Try making it first."));
        return serviceShort;
        
        //     return serviceShort;
        // } catch (Exception e) {
        //     throw new NotFoundException("Short URL not found. Try making it first.");
        // }
    }

    public List<Short> getAllShorts(){
        return shortRepository.findAll();
    }

    public Short getLastShort(){
        return shortRepository.findTopByOrderByUrlIdDesc();
    }
    
}
