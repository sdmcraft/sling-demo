package com.github.sdmcraft.slingdemo;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.jackrabbit.server.io.DeleteContext;
import org.apache.jackrabbit.server.io.DeleteHandler;
import org.apache.jackrabbit.webdav.DavException;
import org.apache.jackrabbit.webdav.DavResource;
import org.apache.jackrabbit.webdav.DavServletResponse;
import org.osgi.framework.Constants;


import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

@Component(immediate = true)
@Properties({
        @Property(name = Constants.SERVICE_RANKING, intValue = 10, propertyPrivate = false)
})

@Service
public class DemoDeleteHandler implements DeleteHandler {
    @Override
    public boolean delete(DeleteContext deleteContext, DavResource member) throws DavException {
        System.out.println(">>>>>>>>>>>Custom delete handler deleting");
        try {
            String itemPath = member.getLocator().getRepositoryPath();
            Item item = deleteContext.getSession().getItem(itemPath);
            if (item instanceof Node) {
                ((Node) item).removeShare();
            } else {
                item.remove();
            }
            deleteContext.getSession().save();
            return true;
        } catch (RepositoryException e) {
            throw new DavException(DavServletResponse.SC_UNPROCESSABLE_ENTITY ,e);
        }

    }

    @Override
    public boolean canDelete(DeleteContext deleteContext, DavResource davResource) {
        return true;
    }
}
