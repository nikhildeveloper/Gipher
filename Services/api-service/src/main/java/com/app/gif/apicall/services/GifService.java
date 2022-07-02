package com.app.gif.apicall.services;

import com.app.gif.apicall.Domains.Gif;

public interface GifService {
    Gif getGif(String query);

    Gif gettrendinggifs();
}
