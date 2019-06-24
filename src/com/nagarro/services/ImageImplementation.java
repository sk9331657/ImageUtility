package com.nagarro.services;

import com.nagarro.models.Image;
import com.nagarro.utils.Hibernate;
import org.hibernate.Session;
import org.hibernate.Query;



@SuppressWarnings("deprecation")
public class ImageImplementation {

	   public void addImage(Image image) {
	        try (Session session = Hibernate.getSessionInstance();) {
	            session.getTransaction().begin();
	            session.save(image);
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    /*
	     * get an image from database
	     */
	    
	    public Image getImage(String imageId) {
	        Image image = null;
	        System.out.println(imageId);
	        try (Session session = Hibernate.getSessionInstance()) {
	            session.getTransaction().begin();
	            String queryString = "from Image where imageId = :imageId";
				Query query = session.createQuery(queryString).setString("imageId", imageId);

	            Object queryResult = query.uniqueResult();
	            System.out.println(queryResult);
	            return (Image) queryResult;
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            System.out.println("Unable to connect to database");
	        }
	        return image;
	    }

	    /*
	     * method to edit an image
	     */
	    
	    public void editImage(Image newImage) {
	        try (Session session = Hibernate.getSessionInstance();) {
	            session.beginTransaction();
	            session.update(newImage);
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    /*
	     * method to delete an image present in database using HQL
	     */
	    
	    public void deleteImage(String imageid) {
	        try (Session session = Hibernate.getSessionInstance();) {
	            session.beginTransaction();

	            String query = "delete from Image where imageId= :imageId";
	            session.createQuery(query).setString("imageId", imageid).executeUpdate();
	            session.getTransaction().commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
