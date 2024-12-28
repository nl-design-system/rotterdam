import { PropsWithChildren } from 'react';
import './CustomIconGallery.css';

export const CustomIconGallery = ({ children }: PropsWithChildren) => (
  <div className="utrecht-custom-icon-gallery">{children}</div>
);

export const CustomIconGalleryItem = ({ name, children }: PropsWithChildren<{ name?: string }>) => (
  <div className="utrecht-custom-icon-gallery-item">
    {children && <div className="utrecht-custom-icon-gallery-item__icon">{children}</div>}
    {name && <div className="utrecht-custom-icon-gallery-item__name">{name}</div>}
  </div>
);
