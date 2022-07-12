package com.app.directv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.directv.bo.Channel;
import com.app.directv.bo.Content;
import com.app.directv.bo.Series;
import com.app.directv.repo.IDirecTvRepository;
import com.app.directv.repo.IDirecTvRepositoryChannel;
import com.app.directv.repo.IDirecTvRepositoryContent;

@RestController
public class DirecTvRequestController {
	@Autowired
	private IDirecTvRepository idtv;
	@Autowired
	private IDirecTvRepositoryContent idtvContent;
	@Autowired
	private IDirecTvRepositoryChannel idtvChannel;
	
	@Autowired
	private MongoTemplate template;
	
	@PostMapping("/submitDirecTVData")
	public String getDirecTvRequestType(@RequestBody Map<String,Object> obj,HttpSession request){
		Series s1=null;
		Content c1=null;
		Channel channel=null;
		if(obj.get("resourceType").toString().equalsIgnoreCase("SERIES")) {
			 s1=makeARequestForSeries(obj);
			 idtv.save(s1);
		}else if(obj.get("resourceType").toString().equalsIgnoreCase("CONTENT")) {
			c1=makeARequestForContent(obj);
			idtvContent.save(c1);
		}else if(obj.get("resourceType").toString().equalsIgnoreCase("CHANNEL")) {
			 channel=makeARequestForChannel(obj);
			 idtvChannel.save(channel);
		}	
		
        return "Added Successfully";		
	}
	
	@GetMapping("/getAllRecords")
    public Object getAllRecords() {        
        List<Series> series=idtv.findAll();
        List<Content> content=idtvContent.findAll();
        List<Channel> channel=idtvChannel.findAll();
      List<Object> l1=new ArrayList<Object>();
      l1.add(content);
      l1.add(series);
      l1.add(channel);
        return l1;
    }
	
	@GetMapping("/getRecordByID/{id}")
    public Object getRecordByID(@PathVariable(value = "id") String id) throws ResourceNotFoundException{    
		Series s1=null;
		Content c1=null;
		Channel channel=null;
		try {
    		 s1 = idtv.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
    		 return s1;
    	}catch (Exception e) {
    		System.err.println("Exception::"+e);
    		
		}
    	try {
    		 c1 = idtvContent.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
    		 return c1;
		} catch (Exception e) {
			System.err.println("Exception::"+e);
		}  	
    	try {
    		channel = idtvChannel.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
    		return channel;
		} catch (Exception e) {
			System.err.println("Exception::"+e);
		}
    	
		return null;
		
    }
	
	
	  @DeleteMapping("/delete/{id}") 
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable(value = "id") String id) throws ResourceNotFoundException{
	    try {
			/*
			 * Query query=new Query(); query.addCriteria(Criteria.where("id").is(id));
			 * template.findAndRemove(query, Series.class); template.findAndRemove(query,
			 * Content.class);
			 */
	    	try {
	    		Series s1 = idtv.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
	    		
	    		if(s1!=null) {
	    	    	idtv.delete(s1);
	    	    	}
	    	}catch (Exception e) {
	    		System.err.println("Exception::"+e);
			}
	    	try {
	    		Content c1 = idtvContent.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		    	if(c1!=null) {
		    		idtvContent.delete(c1);
		    	}
			} catch (Exception e) {
				System.err.println("Exception::"+e);
			}  	
	    	try {
	    		Channel ch1 = idtvChannel.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		    	if(ch1!=null) {
		    		idtvChannel.delete(ch1);
		    	}
			} catch (Exception e) {
				System.err.println("Exception::"+e);
			}  
	    	
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	
	private Channel makeARequestForChannel(Map<String, Object> obj) {
		Channel s1=new Channel();
		s1.setResourceType(obj.get("resourceType").toString());
		s1.setItemType(obj.get("itemType").toString());
		s1.setMajorChannelNumber(Integer.parseInt(obj.get("majorChannelNumber").toString()));
		s1.setName(obj.get("name").toString());
		s1.setDescription(obj.get("description").toString());
		s1.setCcId(Integer.parseInt(obj.get("ccId").toString()));
		s1.setMarketId(Integer.parseInt(obj.get("marketId").toString()));
		s1.setResourceId(obj.get("resourceId").toString());
		return s1;
	}

	private Series makeARequestForSeries(Map<String, Object> obj) {
		Series s1=new Series();
		s1.setResourceType(obj.get("resourceType").toString());
		s1.setItemType(obj.get("itemType").toString());
		s1.setTitle(obj.get("title").toString());
		s1.setDescription(obj.get("description").toString());
		s1.setMetadataLanguage(obj.get("metadataLanguage").toString());
		List<String> generList=(List<String>)obj.get("genres");
		List<Map<String,Object>> seasonsList= (List<Map<String, Object>>) obj.get("seasons");
		Map<String,Object> auglist=(Map<String, Object>) obj.get("augmentation");
		List<String> catList=(List<String>) obj.get("categories");
		s1.setGenres(generList);
		s1.setSeasons(seasonsList);
		s1.setParentalRating(obj.get("parentalRating").toString());
		s1.setAugmentation(auglist);
		s1.setCategories(catList);
		s1.setProgramAttribution(obj.get("programAttribution").toString());
		s1.setResourceId(obj.get("resourceId").toString());	
		return s1;
	}
	private Content makeARequestForContent(Map<String, Object> obj) {
		Content c1=new Content();
		c1.setResourceType(obj.get("resourceType").toString());
		c1.setItemType(obj.get("itemType").toString());
		c1.setContentType(obj.get("contentType").toString());
		c1.setTitle(obj.get("title").toString());
		c1.setDisplayTitle(obj.get("displayTitle").toString());
		c1.setDescription(obj.get("description").toString());
		c1.setMetadataLanguage(obj.get("metadataLanguage").toString());
		c1.setParentalRating(obj.get("parentalRating").toString());
		List<String> generList=(List<String>)obj.get("genres");
		c1.setGenres(generList);
		c1.setOriginalAirDate(obj.get("originalAirDate").toString());
		c1.setReleaseYear(obj.get("releaseYear").toString());
		List<String> catList=(List<String>) obj.get("categories");
		c1.setCategories(catList);
		c1.setResourceId(obj.get("resourceId").toString());
		return c1;
	}
	
	
	
	
	

}
