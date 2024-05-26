package com.aam.gmapextechnicalinterview.presentation.utils

import com.aam.gmapextechnicalinterview.data.model.response.Info
import java.net.URL

/**
 * Utility for cleaning and manipulating pagination URLs.
 */
object CleanUpPaginationUrlUtils {

    /**
     * Cleans up the page count and returns a formatted string indicating the current page and the total pages.
     *
     * @param info Pagination information containing details such as the current page and the total pages.
     * @return A formatted string indicating the current page and the total pages.
     */
    fun cleanUpPageCount(info: Info): String {
        val currentPage =
            if (info.prev.isNullOrBlank()) 1.toString() else (cleanUpPageNumber(info.prev.toString())!! + 1).toString()
        return "${currentPage}/${info.pages}"
    }

    /**
     * Cleans up the page number from a pagination URL and returns it as an integer.
     *
     * @param urlPages The URL containing the page information.
     * @return The page number as an integer or null if it cannot be extracted.
     */
    fun cleanUpPageNumber(urlPages: String): Int? {
        val pageUrlQuery = URL(urlPages).query
        val params = pageUrlQuery.split("&")
        for (singleParam in params) {
            val value = singleParam.split("=")
            if (value[0] == "page" && value.size == 2) {
                return value[1].toInt()
            }
        }
        return if (!pageUrlQuery.isNullOrBlank()) pageUrlQuery.substringAfter('=').toInt() else null
    }
}