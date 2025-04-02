/*
 * Copyright (c) Andrew Grant of Carrick Software 11/03/2025, 22:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.controllers.places.regions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@SuppressWarnings("unused")
@Controller
public interface RegionListController {

    String getListPage(final Model model);

    String getNextPage(final Model model);

    String getPreviousPage(final Model model);

    String getFirstPage(final Model model);

    String getLastPage(final Model model);

    String regionDelete(@PathVariable String id);

    int getPageNumber();
}
