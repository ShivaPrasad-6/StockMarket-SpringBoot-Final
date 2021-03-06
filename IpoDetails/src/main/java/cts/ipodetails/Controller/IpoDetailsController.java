package cts.ipodetails.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cts.ipodetails.dao.IpoDetailsRepository;
import cts.ipodetails.pojo.IpoDetails;





@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/IpoDetails")
public class IpoDetailsController {

	@Autowired

	private IpoDetailsRepository ipodetailsRepository;

	@RequestMapping("/getAllIpoDetails")

	public Iterable<IpoDetails> getAllIpoDetails() {

		return ipodetailsRepository.findAll();

	}

	@PostMapping("/saveIpoDetails")

	public IpoDetails saveIpoDetails(@RequestBody IpoDetails ipodetails) {

		System.out.println(ipodetails);

		ipodetailsRepository.save(ipodetails);

		return ipodetails;

	}

	@PutMapping("/updateIpoDetails/{ipoid}")

	public IpoDetails updateIpoDetails(@RequestBody IpoDetails ipodetails, @PathVariable("ipoid") Integer ipoid) {

		ipodetails.setIpoid(ipoid);

		System.out.println(ipodetails);

		ipodetailsRepository.save(ipodetails);

		return ipodetails;

	}

	@DeleteMapping("/deleteIpoDetails/{ipoid}")

	public Boolean deleteIpoDetails(@PathVariable("ipoid") Integer ipoid) {

		System.out.println(ipoid);

		Optional<IpoDetails> ipodetails = ipodetailsRepository.findById(ipoid);

		ipodetailsRepository.delete(ipodetails.get());

		return true;

	}

	@GetMapping("/findOneInAll2/{ipoid}")

	public IpoDetails findOneInAll2(@PathVariable("ipoid") Integer ipoid)

	{

		Optional<IpoDetails> ipodetails = ipodetailsRepository.findById(ipoid);

		return ipodetails.get();

	}

}