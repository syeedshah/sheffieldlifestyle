package org.lifestyle.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.lifestyle.com.domain.Business;
import org.lifestyle.com.domain.Image;
import org.lifestyle.com.domain.Kids;
import org.lifestyle.com.domain.Lifestyle;
import org.lifestyle.com.domain.News;
import org.lifestyle.com.domain.Nightlife;
import org.lifestyle.com.dto.KidsDto;
import org.lifestyle.com.dto.NightlifeDto;
import org.lifestyle.com.service.BusinessService;
import org.lifestyle.com.service.DiningService;
import org.lifestyle.com.service.ImageService;
import org.lifestyle.com.service.KidsService;
import org.lifestyle.com.service.LandmarkService;
import org.lifestyle.com.service.LifestyleService;
import org.lifestyle.com.service.NewsService;
import org.lifestyle.com.service.NightlifeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles and retrieves person request
 */
@SuppressWarnings("restriction")
@Controller
public class MainController {

	protected static Logger logger = Logger.getLogger("mainController");
	protected static String SECTION = "BE_HOMEPAGE";
	protected static String LEVEL = "LEVEL_ONE";
	protected static int RANDOM_ENTRIES = 3;

	
	@Resource(name = "businessService")
	private BusinessService businessService;
	@Resource(name = "newsService")
	private NewsService newsService;
	@Resource(name = "landmarkService")
	private LandmarkService landmarkService;
	@Resource(name = "lifestyleService")
	private LifestyleService lifestyleService;
	@Resource(name = "kidsService")
	private KidsService kidsService;
	@Resource(name = "diningService")
	private DiningService diningService;
	@Resource(name = "nightlifeService")
	private NightlifeService nightlifeService;
	@Resource(name = "imageService")
	private ImageService imageService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getTest(Model model) {

		logger.debug("Received request to show home page");
		List<NightlifeDto> nightlifeDtos = new ArrayList<>();
		NightlifeDto nlDto = null;
		List<KidsDto> kidsDtos = new ArrayList<>();
		KidsDto kidsDto = null;
		
		model.addAttribute("SECTION", SECTION);
		model.addAttribute("LEVEL", LEVEL);

		List<Kids> kidsList = kidsService.getRandomEntries();
		for (Kids kids : kidsList) {
			kidsDto = new KidsDto();
			kidsDto.setId(kids.getId());
			kidsDto.setName(kids.getName());
			kidsDto.setEmail(kids.getEmail());
			kidsDto.setLargeDescription(kids.getLargeDescription());
			List<Image> imagelist = imageService.getImageByLink(kids.getName());
			if(CollectionUtils.isEmpty(imagelist)){
				imagelist = imageService.getImageByLink("kids_placeholder_80");
			}
			kidsDto.setImgPath(imagelist.get(0).getImagePath());
			kidsDtos.add(kidsDto); 
		}
		List<News> news = newsService.getLatest();
		List<Business> business = businessService.getRandomEntries();
		// List<Landmark> landmarks = landmarkService.getRandomEntries();
		List<Lifestyle> lifestyle = lifestyleService.getRandomEntries();

		List<Nightlife> nightlifeList = nightlifeService.getRandomEntries();
		for (Nightlife nightlife : nightlifeList) {
			nlDto = new NightlifeDto();
			nlDto.setClub_id(nightlife.getClub_id());
			nlDto.setName(nightlife.getName());
			nlDto.setEmail(nightlife.getEmail());
			nlDto.setLargeDescription(nightlife.getLargeDescription());
			List<Image> imagelist = imageService
					.getImageByLink(nlDto.getName());
			if (CollectionUtils.isEmpty(imagelist)) {
				imagelist = imageService
						.getImageByLink("nightlife_placeholder_80");
			}
			nlDto.setImgPath(imagelist.get(0).getImagePath());
			nightlifeDtos.add(nlDto);
		}

		model.addAttribute("NEWS", news);
		model.addAttribute("KIDS", kidsDtos);
		model.addAttribute("BUSINESS", business);
		model.addAttribute("NIGHTLIFE", nightlifeDtos);
		// model.addAttribute("LANDMARKS", landmarks);
		model.addAttribute("LIFESTYLE", lifestyle);
		return "page_structure";
	}

}
