package com.nagarro.controllers;

import java.util.Collection;

import com.nagarro.models.Image;
import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

public class GetImagesSize {

	private static double totalSize = 0;
    private static LoginImplementation loginImplementation = new LoginImplementation();
    private static User user;
    private static Collection<Image> images;


    public static double getImagesSize(String username) {
        user = loginImplementation.getUserDetails(username);
        images = user.getImages();
        for (Image image : images) {
            totalSize += image.getImageSize();
        }
        return totalSize;
    }
}
