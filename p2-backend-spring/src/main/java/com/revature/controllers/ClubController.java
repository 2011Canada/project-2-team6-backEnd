package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.models.Club;
import com.revature.models.ClubBookAssociation;
import com.revature.models.ClubComment;
import com.revature.models.ClubMemberAssociation;
import com.revature.models.User;
import com.revature.services.ClubService;


@RestController
@CrossOrigin(origins="http://ec2-13-58-108-231.us-east-2.compute.amazonaws.com" )
@RequestMapping("/clubs")
public class ClubController {
	
	private ClubService cs;
	
	@Autowired
	public ClubController(ClubService cs) {
		this.cs = cs;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Club>> getAllClubs() {
		return new ResponseEntity<List<Club>>(cs.getAllClubs(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Club> saveNewClub(@RequestBody Club club) {
		return new ResponseEntity<Club>(cs.saveClub(club), HttpStatus.CREATED);
	}
	
	@GetMapping("/{clubId}")
	public ResponseEntity<Club> getClub(@PathVariable int clubId) {
		return new ResponseEntity<Club>(cs.getClubByClubId(clubId), HttpStatus.OK);
	}
	
	@GetMapping("/{clubId}/members")
	public ResponseEntity<List<User>> getAllClubMembers(@PathVariable int clubId) {
		return new ResponseEntity<List<User>>(cs.getUsersByClubId(clubId), HttpStatus.OK);
	}
	
	
	@PostMapping("/{clubId}/members")
	public ResponseEntity<ClubMemberAssociation> addMemberToClub(@RequestBody User user, @PathVariable int clubId) {
		return new ResponseEntity<ClubMemberAssociation>(cs.saveClubMemberAssociation(new ClubMemberAssociation(user.getUserId(), clubId)), HttpStatus.CREATED);
	}
	
	@PostMapping("/{clubId}/description")
	public ResponseEntity<Club> updateClubDescription(@PathVariable int clubId, @RequestBody String newClubDescription) {
		return new ResponseEntity<Club>(cs.updateClubDescriptionByClubId(clubId, newClubDescription), HttpStatus.ACCEPTED);
	}
	@GetMapping("/{clubId}/description")
	public ResponseEntity<String> getClubDescription(@PathVariable int clubId) {
		return new ResponseEntity<String>(cs.getClubDescriptionByClubId(clubId), HttpStatus.OK);
	}
	
	@PostMapping("/{clubId}/name")
	public ResponseEntity<Club> updateClubName(@PathVariable int clubId, @RequestBody String newClubName) {
		return new ResponseEntity<Club>(cs.updateClubDescriptionByClubId(clubId, newClubName), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{clubId}/books")
	public ResponseEntity<List<String>> getBooksByClubId(@PathVariable int clubId) {
		return new ResponseEntity<List<String>> (cs.getBooksByClubId(clubId), HttpStatus.OK);
	}
	
	@PostMapping("/{clubId}/books")
	public ResponseEntity<ClubBookAssociation> saveClubBookAssociation(@PathVariable int clubId, @RequestBody Book book) {
		return new ResponseEntity<ClubBookAssociation>(cs.saveClubBookAssociation(new ClubBookAssociation(book.getBookId(), clubId)), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{clubId}/books")
	public @ResponseBody void deleteClubBookAssociation(@PathVariable int clubId, @RequestBody String bookId) {
		cs.removeClubBookAssociation(new ClubBookAssociation(bookId, clubId));
	}
	
	@DeleteMapping("/{clubId}/members")
	public @ResponseBody void deleteClubMemberAssociation(@PathVariable int clubId, @RequestBody User user) {
		cs.removeClubMemberAssociation(new ClubMemberAssociation(user.getUserId(), clubId));
	}
	@DeleteMapping("/{clubId}")
	public @ResponseBody void deleteClub(@PathVariable int clubId) {
		cs.deleteClubByClubId(clubId);
	}
	
	//Takes in a club comment object without commentId EXAMPLE: {"clubId": "1", "comment": "I don't like this club at all.", "userId": "3"}
	@PostMapping("/{clubId}/comments")
	public ResponseEntity<ClubComment> saveClubComment(@PathVariable int clubId, @RequestBody ClubComment cc) {
		return new ResponseEntity<ClubComment>(cs.saveClubComment(cc), HttpStatus.CREATED);
	}
	
	@GetMapping("/{clubId}/comments")
	public ResponseEntity<List<ClubComment>> getClubCommentsByClubId(@PathVariable int clubId) {
		return new ResponseEntity<List<ClubComment>>(cs.getClubCommentsByClubId(clubId), HttpStatus.OK);
	}
	
	//Also takes in a club comment object with commentId EXAMPLE: {"commentId": "1", clubId": "1", "comment": "I don't like this club at all.", "userId": "3"}
	@DeleteMapping("/{clubId}/comments")
	public @ResponseBody void deleteComment(@RequestBody ClubComment cc) {
		cs.removeClubComment(cc);
	}
	
	
	
}
