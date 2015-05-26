package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.tika.Tika;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by satyadeep on 5/5/15.
 */
@Component(immediate = true)
@Service(Detector.class)
public class ContentBasedTikaDetector implements Detector {
    @Override public MediaType detect(InputStream inputStream,
            Metadata metadata) throws IOException {
        Tika tika = new Tika();
        String mediaType = tika.detect(inputStream);
        return MediaType.parse(mediaType);
    }
}
