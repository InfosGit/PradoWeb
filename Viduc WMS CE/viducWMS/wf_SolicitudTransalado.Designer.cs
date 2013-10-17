namespace viducWMS
{
    partial class wf_SolicitudTransalado
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.dgSolicitudesTraslado = new System.Windows.Forms.DataGrid();
            this.btnSalir = new System.Windows.Forms.Button();
            this.cmbSolictudesTraslado = new System.Windows.Forms.ComboBox();
            this.lblTitle = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // dgSolicitudesTraslado
            // 
            this.dgSolicitudesTraslado.BackColor = System.Drawing.Color.White;
            this.dgSolicitudesTraslado.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgSolicitudesTraslado.Location = new System.Drawing.Point(5, 32);
            this.dgSolicitudesTraslado.Name = "dgSolicitudesTraslado";
            this.dgSolicitudesTraslado.Size = new System.Drawing.Size(231, 228);
            this.dgSolicitudesTraslado.TabIndex = 0;
            this.dgSolicitudesTraslado.DoubleClick += new System.EventHandler(this.dgSolicitudesTraslado_DoubleClick);
            this.dgSolicitudesTraslado.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.dgSolicitudes_KeyPress);
            this.dgSolicitudesTraslado.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgSolicitudesTraslado_KeyUp);
            this.dgSolicitudesTraslado.KeyDown += new System.Windows.Forms.KeyEventHandler(this.dgSolicitudesTraslado_KeyDown);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Navy;
            this.btnSalir.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnSalir.ForeColor = System.Drawing.Color.White;
            this.btnSalir.Location = new System.Drawing.Point(154, 263);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(82, 30);
            this.btnSalir.TabIndex = 1;
            this.btnSalir.Text = "Cancelar";
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // cmbSolictudesTraslado
            // 
            this.cmbSolictudesTraslado.Location = new System.Drawing.Point(66, 5);
            this.cmbSolictudesTraslado.Name = "cmbSolictudesTraslado";
            this.cmbSolictudesTraslado.Size = new System.Drawing.Size(170, 22);
            this.cmbSolictudesTraslado.TabIndex = 2;
            this.cmbSolictudesTraslado.SelectedIndexChanged += new System.EventHandler(this.cmbSolictudesTraslado_SelectedIndexChanged);
            this.cmbSolictudesTraslado.KeyUp += new System.Windows.Forms.KeyEventHandler(this.cmbSolictudesTraslado_KeyUp);
            // 
            // lblTitle
            // 
            this.lblTitle.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.lblTitle.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lblTitle.ForeColor = System.Drawing.Color.Navy;
            this.lblTitle.Location = new System.Drawing.Point(6, 8);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(58, 13);
            this.lblTitle.Text = "Solicitud:";
            this.lblTitle.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // wf_SolicitudTransalado
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.ControlBox = false;
            this.Controls.Add(this.lblTitle);
            this.Controls.Add(this.cmbSolictudesTraslado);
            this.Controls.Add(this.dgSolicitudesTraslado);
            this.Controls.Add(this.btnSalir);
            this.MinimizeBox = false;
            this.Name = "wf_SolicitudTransalado";
            this.Text = "Solicitudes de transalado";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGrid dgSolicitudesTraslado;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.ComboBox cmbSolictudesTraslado;
        private System.Windows.Forms.Label lblTitle;
    }
}