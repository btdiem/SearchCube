package datacube.search.share.interfaces;

import datacube.search.share.impl.InvariantBroken;

public interface HasInvariant {

	public boolean invariant() throws InvariantBroken;
}
