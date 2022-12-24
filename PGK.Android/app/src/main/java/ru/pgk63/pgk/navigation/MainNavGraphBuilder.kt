package ru.pgk63.pgk.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.feature_student.navigation.StudentDetailsDestination
import com.example.feature_student.navigation.StudentListDestination
import com.example.feature_student.navigation.studentNavigation
import ru.pgk63.feature_auth.navigation.authNavigation
import ru.pgk63.feature_group.navigation.GroupListDestination
import ru.pgk63.feature_group.navigation.GroupDetailsDestination
import ru.pgk63.feature_group.navigation.groupNavigation
import ru.pgk63.feature_main.navigation.mainNavigation
import ru.pgk63.feature_settings.navigation.*
import ru.pgk63.feature_specialization.navigation.SpecializationDetailsDestination
import ru.pgk63.feature_specialization.navigation.SpecializationListDestination
import ru.pgk63.feature_specialization.navigation.specializationNavigation
import ru.pgk63.feature_subject.navigation.SubjectDetailsDestination
import ru.pgk63.feature_subject.navigation.SubjectListDestination
import ru.pgk63.feature_subject.navigation.subjectNavigation
import ru.pgk63.feature_tech_support.navigation.TechSupportChatDestination
import ru.pgk63.feature_tech_support.navigation.techSupportNavigation

fun NavGraphBuilder.mainNavGraphBuilder(
    navController: NavController
){
    mainNavigation(
        onTechSupportChatScreen = {
            navController.navigate(TechSupportChatDestination.route)
        },
        onGroupScreen = {
            navController.navigate(GroupListDestination.route)
        },
        onSpecializationListScreen = {
            navController.navigate(SpecializationListDestination.route)
        },
        onSubjectListScreen = {
            navController.navigate(SubjectListDestination.route)
        },
        onStudentListScreen = {
            navController.navigate(StudentListDestination.route)
        },
        onSettingsScreen = {
            navController.navigate(SettingsDestination.route)
        }
    )

    authNavigation()

    groupNavigation(
        onGroupDetailsScreen = { id ->
            navController.navigate("${GroupDetailsDestination.route}/$id")
        },
        onBackScreen = { navController.navigateUp() }
    )

    techSupportNavigation(
        onBackScreen = { navController.navigateUp() }
    )

    specializationNavigation(
        onBackScreen = { navController.navigateUp() },
        onSpecializationDetailsScreen = { id ->
            navController.navigate("${SpecializationDetailsDestination.route}/$id")
        }
    )

    subjectNavigation(
        onBackScreen = { navController.navigateUp() },
        onSubjectDetailsScreen = { id ->
            navController.navigate("${SubjectDetailsDestination.route}/$id")
        }
    )

    studentNavigation(
        onBackScreen = { navController.navigateUp() },
        onStudentDetailsScreen = { id ->
            navController.navigate("${StudentDetailsDestination.route}/$id")
        }
    )

    settingsNavigation(
        onBackScreen = { navController.navigateUp() },
        onSettingsSecurityScreen = {
            navController.navigate(SettingsSecurityDestination.route)
        },
        onSettingsNotificationsScreen = {
            navController.navigate(SettingsNotificationsDestination.route)
        },
        onSettingsLanguageScreen = {
            navController.navigate(SettingsLanguageDestination.route)
        },
        onSettingsAppearanceScreen = {
            navController.navigate(SettingsAppearanceDestination.route)
        }
    )
}