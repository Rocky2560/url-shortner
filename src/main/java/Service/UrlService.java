package Service;

import Model.UrlMapping;
import Repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String shortenUrl (String longUrl)
    {
        String shortcode = UUID.randomUUID().toString().substring(0,6);
        UrlMapping urlMapping = new UrlMapping(shortcode, longUrl, LocalDateTime.now());
        urlRepository.save(urlMapping);
        return shortcode;
    }

    public String getOriginalUrl(String shortCode)
    {
        return urlRepository.findById(shortCode).orElseThrow(()
                -> new RuntimeException("Short Url not found")).getLongUrl();
    }


}
