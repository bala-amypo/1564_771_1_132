// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.MatchRecord;
// import com.example.demo.model.SkillOffer;
// import com.example.demo.model.SkillRequest;
// import com.example.demo.model.UserProfile;
// import com.example.demo.repository.MatchRecordRepository;
// import com.example.demo.repository.SkillOfferRepository;
// import com.example.demo.repository.SkillRequestRepository;
// import com.example.demo.repository.UserProfileRepository;
// import com.example.demo.service.MatchmakingService;

// import java.util.List;

// @Service
// public class MatchmakingServiceImpl implements MatchmakingService {

//     private final MatchRecordRepository matchRecordRepository;
//     private final UserProfileRepository userProfileRepository;
//     private final SkillOfferRepository skillOfferRepository;
//     private final SkillRequestRepository skillRequestRepository;

//     public MatchmakingServiceImpl(
//             MatchRecordRepository matchRecordRepository,
//             UserProfileRepository userProfileRepository,
//             SkillOfferRepository skillOfferRepository,
//             SkillRequestRepository skillRequestRepository) {

//         this.matchRecordRepository = matchRecordRepository;
//         this.userProfileRepository = userProfileRepository;
//         this.skillOfferRepository = skillOfferRepository;
//         this.skillRequestRepository = skillRequestRepository;
//     }

//     @Override
//     public MatchRecord generateMatch(Long userId) {

//         UserProfile userA = userProfileRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("UserProfile not found"));

//         List<SkillRequest> requestsA = skillRequestRepository.findByUser_Id(userId);
//         List<SkillOffer> offersA = skillOfferRepository.findByUser_Id(userId);

//         for (SkillRequest requestA : requestsA) {

//             List<SkillOffer> offersB =
//                     skillOfferRepository.findBySkill_Id(requestA.getSkill().getId());

//             for (SkillOffer offerB : offersB) {

//                 if (offerB.getUser().getId().equals(userId)) {
//                     continue;
//                 }

//                 UserProfile userB = offerB.getUser();
//                 List<SkillRequest> requestsB =
//                         skillRequestRepository.findByUser_Id(userB.getId());

//                 for (SkillRequest requestB : requestsB) {
//                     for (SkillOffer offerA : offersA) {

//                         if (offerA.getSkill().getId()
//                                 .equals(requestB.getSkill().getId())) {

//                             MatchRecord match = new MatchRecord();
//                             match.setUserA(userA);
//                             match.setUserB(userB);
//                             match.setSkillOfferedByA(offerA.getSkill());
//                             match.setSkillOfferedByB(offerB.getSkill());

//                             return matchRecordRepository.save(match);
//                         }
//                     }
//                 }
//             }
//         }

//         throw new RuntimeException("No match found");
//     }

//     @Override
//     public MatchRecord getMatchById(Long id) {
//         return matchRecordRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Match not found"));
//     }

//     @Override
//     public List<MatchRecord> getMatchesForUser(Long userId) {
//         return matchRecordRepository.findByUserA_IdOrUserB_Id(userId, userId);
//     }

//     @Override
//     public void updateMatchStatus(Long id, String status) {
//         MatchRecord match = getMatchById(id);
//         match.setStatus(status);
//         matchRecordRepository.save(match);
//     }
// }
